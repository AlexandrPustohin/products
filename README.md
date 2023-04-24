#Сервис организаций и продуктов
Эндпоинты:
Добавление организации
POST http://localhost:8089/v1/org/add
{
"name": "ООО Тест",
"description":"тестовая организация",
"logo": "Логотип",
"isActive": true,
"isDeleted": false
}

Получение организации по ИД
GET http://localhost:8089/v1/org/{1}
Получение всех организаций
GET http://localhost:8089/v1/org/all
Бан для организации
GET http://localhost:8089/v1/org/1/setban
Снятие бана
GET http://localhost:8089/v1/org/1/setnoban


Добавление продукта для организации (id = 1)
POST http://localhost:8089/v1/prod/add/{1}
{
"name": "Хлеб",
"description":"Дарницкий ",
"count": 20
}

Получение продукта по ID
GET http://localhost:8089/v1/prod/{10}

Получение всех продуктов
GET http://localhost:8089/v1/prod/all

Получение продуктов организации
GET http://localhost:8089/v1/prod/org/{2}



