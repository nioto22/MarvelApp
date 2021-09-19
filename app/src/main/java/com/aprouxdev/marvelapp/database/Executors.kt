package com.aprouxdev.marvelapp.database

import java.util.concurrent.Executors

/*
* Created by antoine on 19.09.21.
*/

private val IO_EXECUTOR = Executors.newSingleThreadExecutor()

/**
 * Utility method to run blocks on a dedicated background thread, used for io/database work.
 */
fun ioThread(f : () -> Unit) {
    IO_EXECUTOR.execute(f)
}