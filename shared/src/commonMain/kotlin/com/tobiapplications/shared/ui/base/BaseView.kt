package ui.base

interface BaseView {

    fun showProgressIndicator(show: Boolean)
    fun showError(error: Throwable)
}