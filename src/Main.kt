import kotlinx.coroutines.*

fun main() = runBlocking {

    //Задача 1
    println("Решение для задачи 1:")
    startProductPurchaseProgram()

    //Задача 2
    println("Решение для задачи 2:")
    runCounter(CoroutineStart.LAZY)
}

//Функция для задачи 1
suspend fun startProductPurchaseProgram() {
    coroutineScope {
        launch {
            println("Программа покупки продуктов")
            delay(1000L)
            println("Купить товар:\n1.Да\n2.Нет")
            when(readln()) {
                "1" -> {
                    println("Оплата продукта началась")
                    delay(2000L)
                    println("Сканирование и обработка...")
                    delay(2000L)
                    println("Покупка оплачена.")
                }
                "2" -> {
                    println("Отмена покупки...")
                    delay(2000L)
                    println("Покупка отменена.")
                }
                else -> println("Ошибка: введено недопустимое значение!")
            }
        }
    }
    coroutineScope {
        launch {
            println("До свидания")
        }
    }
}

//Функция для задачи 2
suspend fun runCounter(coroutineStart: CoroutineStart) {
    coroutineScope {
        val job = launch(start = coroutineStart) {
            delay(3000L)
            println("Произошел ленивый запуск")
        }
        launch {
            job.start()
            println("Начало программы")
            for (i in 1..4) {
                delay(1000L)
                println(i)
            }
            println("Программа завершена")
        }
    }
}