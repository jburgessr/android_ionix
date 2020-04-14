package cl.jdomynyk.ionix.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cl.jdomynyk.ionix.data.entity.MenuItem
import cl.jdomynyk.ionix.data.entity.User
import cl.jdomynyk.ionix.domain.RemoteResult
import cl.jdomynyk.ionix.domain.usecase.MenuUseCase
import cl.jdomynyk.ionix.domain.usecase.SearchUseCase
import cl.jdomynyk.ionix.presentation.formatter.Formatter
import cl.jdomynyk.ionix.presentation.view.MenuItemCellView
import kotlinx.coroutines.launch

class HomePresenter(
    private val formatter: Formatter,
    private val searchUseCase: SearchUseCase,
    private val menuUseCase: MenuUseCase
) : BasePresenter() {

    private val _menuItems = MutableLiveData<List<MenuItem>>().apply { value = emptyList() }
    val menuItems: LiveData<List<MenuItem>> get() = _menuItems

    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean> get() = _error

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    private val _showRut = MutableLiveData<Any>()
    val showRut: LiveData<Any> get() = _showRut

    fun viewReady() {
        scope().launch {
            when (val result = menuUseCase.getRemote()) {
                is RemoteResult.Success -> {
                    _error.postValue(false)
                    saveLocal(result.items)
                }
                is RemoteResult.Error -> {
                    _error.postValue(true)
                    getLocal()
                }
                is RemoteResult.Exception -> {
                    _error.postValue(true)
                    getLocal()
                }
            }
        }
    }

    private fun saveLocal(list: List<MenuItem>) {
        scope().launch {
            menuUseCase.cleanTable()
            menuUseCase.insertAll(list)
            getLocal()
        }
    }

    private fun getLocal() {
        scope().launch {
            _menuItems.postValue(menuUseCase.getLocal())
        }
    }

    fun populateItem(view: MenuItemCellView, position: Int) {
        val item = _menuItems.value?.get(position)
        if (item != null) {
            view.setIcon(formatter.formatFaIcon(item.icon))
            view.setName(item.name)
        }
    }

    fun getItemsCount(): Int {
        return if (_menuItems.value != null) {
            _menuItems.value!!.size
        } else {
            0
        }
    }

    fun onItemClick(position: Int) {
        when (position) {
            0 -> {
                _showRut.postValue(null)
            }
        }
    }

    fun findUser(rut: String) {
        scope().launch {
            val url = formatter.getRutDes(rut)
            when (val result = searchUseCase.search(url)) {
                is RemoteResult.Success -> {
                    if (result.items.isNotEmpty() && result.items.size > 1)
                        _user.postValue(result.items[1])
                    else
                        _user.postValue(null)
                }
                is RemoteResult.Error -> _user.postValue(null)
                is RemoteResult.Exception -> _user.postValue(null)
            }


        }
    }
}