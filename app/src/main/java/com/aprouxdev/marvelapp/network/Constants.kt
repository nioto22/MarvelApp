package com.aprouxdev.marvelapp.network

class Constants {
    companion object{
        const val MARVEL_BASE_URL = "http://gateway.marvel.com/v1/public/"
        private const val PUBLIC_KEY = "02edcf95907416f7f2e6714f54bd9013"
        private const val MD5_HASH = "f18bebf2cec36c6540754553d8befff7"
        const val MARVEL_PATH_AUTH = "characters?ts=1&apikey=$PUBLIC_KEY&hash=$MD5_HASH"


        //02edcf95907416f7f2e6714f54bd9013&hash=f18bebf2cec36c6540754553d8befff7
    }
}