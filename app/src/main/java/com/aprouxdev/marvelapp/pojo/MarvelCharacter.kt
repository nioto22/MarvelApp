package com.aprouxdev.marvelapp.pojo

class MarvelCharacter {

    var id: Int = 0
    var name: String? = null
    var description: String? = null
    var thumbnail: String? = null
    var comics: List<String>? = null

    // http://gateway.marvel.com/v1/public/characters?ts=1&apikey=ad03578d5d9923b867905c6485d3f738&hash=35779452531a4104aa777fe3d1b38fb3
    // a023716308f5834888aad4c6bdb321c2a413d174
    // 1a023716308f5834888aad4c6bdb321c2a413d174ad03578d5d9923b867905c6485d3f738

}