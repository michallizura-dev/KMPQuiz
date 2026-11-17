package com.example.biomedquiz

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform