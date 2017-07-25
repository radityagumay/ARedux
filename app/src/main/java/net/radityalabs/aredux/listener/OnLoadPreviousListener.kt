package net.radityalabs.aredux.listener

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

/**
 * Created by radityagumay on 7/22/17.
 */

/* for sample */
class OnLoadListener(private val c1: (KCallback) -> Unit,
                     private val c2: (KLoadMoreCallback) -> Unit) : RecyclerView.OnScrollListener() {
    fun doSomething() {
        if (true) {
            KCallback().apply(c1)
        } else {
            KLoadMoreCallback().apply(c2)
        }
    }
}

class OnLoadPreviousListener(private val c1: (KCallback) -> Unit) :
        RecyclerView.OnScrollListener() {

    companion object {
        var scrolling: Boolean = false
            get() = field
            set(value) {
                field = value
            }

        var loading: Boolean = false
            get() = field
            set(value) {
                field = value
            }
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager
        val firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition()

        if (!loading && scrolling) {
            val lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition()
            val totalItemCount = linearLayoutManager.itemCount
            if (firstVisibleItem <= 1 && lastVisibleItem <= totalItemCount - 1) {
                loading = true
                KCallback().apply(c1)
            }
        }
    }

    override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
        scrolling = RecyclerView.SCROLL_STATE_DRAGGING == newState;
    }
}

interface Callback {
    fun onLoadPrevious()
}

interface LoadMoreCallback {
    fun onLoadMore()
}

class KLoadMoreCallback : LoadMoreCallback {

    private var onLoadMore: (() -> Unit)? = null

    override fun onLoadMore() {
        onLoadMore?.invoke()
    }

    fun onLoadPrevious(function: () -> Unit) {
        this.onLoadMore = function
    }
}

class KCallback : Callback {

    private var onLoadPrevious: (() -> Unit)? = null

    override fun onLoadPrevious() {
        onLoadPrevious?.invoke()
    }

    fun onLoadPrevious(function: () -> Unit) {
        this.onLoadPrevious = function
    }
}

