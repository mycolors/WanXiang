package com.fengniao.news.net

import android.text.TextUtils
import com.fengniao.news.net.ApiConstants.URL_NEWS_BEFORE_ZHIHU
import okhttp3.FormBody

class HttpUtils private constructor() {
    private var token: String? = null

    //添加公共参数
    val baseFormBodyBuilder: FormBody.Builder
        get() {
            val builder = FormBody.Builder()
            if (!TextUtils.isEmpty(token))
                builder.add("token", token!!)
            return builder
        }

    fun setToken(token: String) {
        this.token = token
    }




    //获取知乎文章
    fun getZhiHuArticle(date: String, callback: FNCallback) {
        OkHttpManager.instance.getAsyn(URL_NEWS_BEFORE_ZHIHU + date, FNCallbackHolder(URL_NEWS_BEFORE_ZHIHU, callback))
    }

    fun getWebCode(url:String,callback: FNCallback){
        OkHttpManager.instance.getAsyn(url, AllDataCallBackHolder(url,callback))
    }

    companion object {
        private var mHttpUtils: HttpUtils? = null

        val instance: HttpUtils
            get() {
                if (mHttpUtils == null) {
                    mHttpUtils = HttpUtils()
                }
                return mHttpUtils!!
            }
    }

}
