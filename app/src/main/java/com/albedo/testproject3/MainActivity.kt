package com.albedo.testproject3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.EntryPoint


@EntryPoint
class MainActivity : AppCompatActivity() {
//    1. Выводится краткая информация о пользователях (ФИО, фотография, адрес, номер
//    телефона) в виде списка, полученная от https://randomuser.me ;
//    2. По клику на элемент списка на отдельном экране показывается полная информация о
//    выбранном пользователе;
//    3. Данные о пользователях не теряются при перезапуске приложения;
//    4. Нажатие на Email, номер телефона, адрес/координаты отправляет пользователя в
//    приложение, которое может обработать эти данные (почта, звонилка, карты);
//    5. Список пользователей можно обновить принудительно;
//    6. Пользователю выводятся уведомления о возникших ошибках при загрузке данных или
//    работе с ними.


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}