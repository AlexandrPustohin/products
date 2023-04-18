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

Бан для организации
GET http://localhost:8089/v1/org/1/setban
Снятие бана
GET http://localhost:8089/v1/org/1/setnoban