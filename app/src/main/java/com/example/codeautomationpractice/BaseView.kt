package com.example.codeautomationpractice

interface BaseView {
    fun internalServer()

    fun onUnknownError(error: String?)

    fun onTimeout()

    fun onNetworkError()

    fun onConnectionError()
}