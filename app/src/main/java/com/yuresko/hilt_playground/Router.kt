package com.yuresko.hilt_playground

import javax.inject.Inject

interface IRouter {
    fun doSomething()
}

class Router @Inject constructor() : IRouter {

    override fun doSomething() {
        TODO("Not yet implemented")
    }
}
