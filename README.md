# ArticleClient
Simple example ArticleClient with Kafka/Mongo - сервис слушает очередь и проводит запись данных по дате рождения клиента в БД, предварительно собрав информацию с сайта NYT.

Необходимо поднять локальный брокер под Kafkу и сервер MongoDB. Переопределить application.yml. Базовая реализация
