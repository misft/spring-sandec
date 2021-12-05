package com.example.sandecspring.data.responses

abstract class Response {
    abstract val code: Int
    abstract val message: String
}