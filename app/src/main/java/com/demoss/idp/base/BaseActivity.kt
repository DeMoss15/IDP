package com.demoss.idp.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.demoss.idp.base.mvp.BasePresenter
import com.demoss.idp.base.mvp.BaseView

abstract class BaseActivity<Presenter : BasePresenter> : AppCompatActivity(),
    BaseView {

    abstract val presenter: Presenter
    abstract val layoutResourceId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResourceId)
        presenter.attachView(this)
    }

    override fun onStart() {
        super.onStart()
        presenter.viewShown()
    }

    override fun onPause() {
        super.onPause()
        presenter.viewHidden()
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}