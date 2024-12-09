package com.example.mavlianov_hw1_m5

class CounterPresenter {

    private var model = CounterModel()
    private var view: CounterView? = null

    fun attachView(view: CounterView) {
        this.view = view
        view.showResult(model.getCount())
    }

    fun onIncrementClick() {
        model.increment()
        handleSpecialCases(model.getCount())
        view?.showResult(model.getCount())
    }

    fun onDecrement() {
        model.decrement()
        handleSpecialCases(model.getCount())
        view?.showResult(model.getCount())
    }

    fun dettachView() {
        view = null
    }

    private fun handleSpecialCases(count: Int) {
        when (count) {
            10 -> view?.showToast("Поздравляем!")
            15 -> view?.changeTextColorToGreen()
        }
    }
}
