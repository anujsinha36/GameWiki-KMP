package org.example.d9kmptemplate

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform