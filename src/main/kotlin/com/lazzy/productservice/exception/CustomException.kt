package com.lazzy.productservice.exception

class CustomException(
    exceptionMessage: String,
    val statusCode: Int,
    val data: Any? = null
) : RuntimeException(exceptionMessage)