package com.shevy.mymovieapp

data class User(val email: String, val uid: String) {
    // Null default values create a no-argument default constructor, which is needed
    // for deserialization from a DataSnapshot.
}
