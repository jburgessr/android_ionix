package cl.jdomynyk.ionix.plataform.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import cl.jdomynyk.ionix.R
import cl.jdomynyk.ionix.data.entity.User
import cl.jdomynyk.ionix.plataform.ui.adapter.MenuItemAdapter
import cl.jdomynyk.ionix.presentation.HomePresenter
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {
    companion object {
        fun start(activity: Activity) {
            val intent = Intent(activity, HomeActivity::class.java)
            activity.startActivity(intent)
        }
    }

    @Inject
    lateinit var presenter: HomePresenter

    private lateinit var adapter: MenuItemAdapter
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initContext()

        setVersion()

        setUpRecycleView()

        initObserverList()

        initObserverError()

        initObserverUser()

        initObserverRut()

        informPresenterViewIsReady()
    }

    private fun initContext() {
        context = this
    }

    private fun setVersion() {
        val pInfo = packageManager.getPackageInfo(context.packageName, 0)
        tvVersion.text = pInfo.versionName
    }

    private fun setUpRecycleView() {
        recyclerView.layoutManager = GridLayoutManager(context, 3)
        adapter = MenuItemAdapter(context, presenter)
        recyclerView.adapter = adapter
    }

    private fun informPresenterViewIsReady() {
        presenter.viewReady()
    }

    private fun initObserverList() {
        presenter.menuItems.observe(this, Observer { list ->

            if (list.isEmpty())
                btnRetry.visibility = View.VISIBLE
            else
                btnRetry.visibility = View.GONE

            adapter.refresh()

        })
    }

    private fun initObserverError() {
        presenter.error.observe(this, Observer {
            showErrorService()
        })
    }

    private fun initObserverUser() {
        presenter.user.observe(this, Observer { user ->
            if (user != null) {
                showDialogDetail(user)
            } else {
                Snackbar.make(
                    rlRoot,
                    R.string.home_msg_error_service,
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun showDialogDetail(user: User) {

        val inflater = LayoutInflater.from(context)

        @SuppressLint("InflateParams") val view: View = inflater
            .inflate(R.layout.activity_home_detail, null)

        val builder = AlertDialog.Builder(context)
        builder.setView(view)

        val dialog = builder.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(true)
        view.findViewById<TextView>(R.id.tvEmail).text = user.detail.email
        view.findViewById<TextView>(R.id.tvPhone).text = user.detail.phoneNumber
        dialog.show()
    }

    private fun initObserverRut() {
        presenter.showRut.observe(this, Observer {
            showRutDialog()
        })
    }

    @SuppressLint("SetTextI18n")
    private fun showRutDialog() {
        val inflater = LayoutInflater.from(context)

        @SuppressLint("InflateParams") val view: View = inflater
            .inflate(R.layout.activity_home_rut, null)

        val builder = AlertDialog.Builder(context)
        builder.setView(view)

        val dialog = builder.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(true)
        val etRut = view.findViewById<EditText>(R.id.etRut)
        view.findViewById<TextView>(R.id.tv0)
            .setOnClickListener {
                etRut.setText(etRut.text.toString() + view.findViewById<TextView>(R.id.tv0).text.toString())
                formatRut(etRut)
            }
        view.findViewById<TextView>(R.id.tv1).setOnClickListener {
            etRut.setText(etRut.text.toString() + view.findViewById<TextView>(R.id.tv1).text.toString())
            formatRut(etRut)
        }
        view.findViewById<TextView>(R.id.tv2).setOnClickListener {
            etRut.setText(etRut.text.toString() + view.findViewById<TextView>(R.id.tv2).text.toString())
            formatRut(etRut)
        }
        view.findViewById<TextView>(R.id.tv3).setOnClickListener {
            etRut.setText(etRut.text.toString() + view.findViewById<TextView>(R.id.tv3).text.toString())
            formatRut(etRut)
        }
        view.findViewById<TextView>(R.id.tv4).setOnClickListener {
            etRut.setText(etRut.text.toString() + view.findViewById<TextView>(R.id.tv4).text.toString())
            formatRut(etRut)
        }
        view.findViewById<TextView>(R.id.tv5).setOnClickListener {
            etRut.setText(etRut.text.toString() + view.findViewById<TextView>(R.id.tv5).text.toString())
            formatRut(etRut)
        }
        view.findViewById<TextView>(R.id.tv6).setOnClickListener {
            etRut.setText(etRut.text.toString() + view.findViewById<TextView>(R.id.tv6).text.toString())
            formatRut(etRut)
        }
        view.findViewById<TextView>(R.id.tv7).setOnClickListener {
            etRut.setText(etRut.text.toString() + view.findViewById<TextView>(R.id.tv7).text.toString())
            formatRut(etRut)
        }
        view.findViewById<TextView>(R.id.tv8).setOnClickListener {
            etRut.setText(etRut.text.toString() + view.findViewById<TextView>(R.id.tv8).text.toString())
            formatRut(etRut)
        }
        view.findViewById<TextView>(R.id.tv9).setOnClickListener {
            etRut.setText(etRut.text.toString() + view.findViewById<TextView>(R.id.tv9).text.toString())
            formatRut(etRut)
        }
        view.findViewById<TextView>(R.id.tvClean).setOnClickListener {
            etRut.setText("")
        }
        view.findViewById<Button>(R.id.btnSave).setOnClickListener {
            presenter.findUser(etRut.text.toString())
            dialog.dismiss()
        }
        view.findViewById<Button>(R.id.btnClose).setOnClickListener { dialog.dismiss() }

        dialog.show()
    }

    private fun formatRut(editText: EditText) {
        var str = editText.text.toString()

        if (str.length < 2)
            return

        str = StringBuilder(str).insert(str.length - 1, "-").toString()
        editText.setText(str)
    }

    private fun showErrorService() {
        val mySnackbar =
            Snackbar.make(rlRoot, R.string.home_msg_error_service_retry, Snackbar.LENGTH_SHORT)
        mySnackbar.show()
    }
}
