package net.radityalabs.aredux

/**
 * Created by radityagumay on 7/20/17.
 */

data class UserObject(
        var userId: Int,
        var username: String,
        var address: String,
        var followerId: List<Int>,
        var image: String,
        var bio: String
)