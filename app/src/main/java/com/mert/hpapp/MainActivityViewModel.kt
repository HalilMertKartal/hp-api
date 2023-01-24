package com.mert.hpapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mert.hpapp.data.CharHP
import com.mert.hpapp.network.RetrofitInstance
import com.mert.hpapp.network.RetrofitService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivityViewModel: ViewModel() {
    var charHPList: MutableLiveData<ArrayList<CharHP>> = MutableLiveData()

    // Create the retrofit instance and do the subscriptions
    fun callApi() {
        val retrofitInstance = RetrofitInstance.getInstance().create(RetrofitService::class.java)
        // RxJava subscription and observe (didn't understand the details)
        retrofitInstance.getAllCharacters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(charListObserver())
    }

    fun getCharList(): MutableLiveData<ArrayList<CharHP>> {
        return charHPList
    }

    // Set the observer for character list
    private fun charListObserver(): Observer<ArrayList<CharHP>>{
        return object: Observer<ArrayList<CharHP>> {
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: ArrayList<CharHP>) {
                charHPList.postValue(t)
            }

            override fun onError(e: Throwable) {
                charHPList.postValue(null)
            }

            override fun onComplete() {

            }

        }
    }
}