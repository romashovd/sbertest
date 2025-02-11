# sbertest

Функциональные требования:

1 - Система состоит из двух компонентов: серверное приложение и клиент-серверное.

2 - При запуске клиентского приложения происходит подключение к серверу.

3 - Клиентская часть:

   а - Все параметры (адрес сервера, логин и пароль) считываются из конфигурационного файла (.ini или .properties или .yaml);
   
   b - При подключении (или старте приложения), выводится имя сервера;
   
   d - Ответ, полученный с сервера сразу же выводится на экран;
   
   е - Если произошла непредвиденная ситуация (поймали исключение) необходимо вывести сообщение и корректно завершить работу (отключиться от сервера);
   
   f - После вывода имени сервера,  пользователю предлагается ввести свое имя, фамилию, и сообщение. (Прим. "Введите имя:", "Введите фамилию:", "Введите сообщение:").
       Имя и фамилия вводятся только один раз, далее автоматически подставляются во все сообщения серверу;
       
   g - Формируется json-объект формата:

			{
			  "Request": {
				"User": {
				  "Name": "Иван",
				  "SecondName": "Иванов"
				},
				"Message": {
				  "Body": "Привет всем!",
				  "Timestamp": "01.01.2020 12:00:00"
				}
			  }
			}

   Дата проставляется автоматически (берется текущая), в формате, представленном выше, то есть "dd.mm.yyyy HH24:MI:SS".
   После нажатия клавиши Enter(или кнопки отправить) сформированная json отправляется на сервер.	 

4 - Серверная часть:

   а - Сервер производит собственное логирование в файл (использовать log4j). 
       Записывает каждое действие (Клиент <ник> зарегистрировался/подключился, Принято сообщение от клиента<Имя Фамилия>:<сообщение>);
   
   b - Сервер реализует следующую логику:
        Принимает сообщение от пользователя. Парсит json и выводит сообщение на экран (дублирует в лог). Далее формируется ответное сообщение следующего формата:
			
			{
			  "Response": {
				"Message": {
				  "Body": "Добрый день, 'имя пользователя', Ваше сообщение успешно обработано!",
				  "Timestamp": "01.01.2020 12:01:00"
				}
			  }
			}       
           
   Дата проставляется автоматически (берется текущая), в формате, представленном выше, то есть "dd.mm.yyyy HH24:MI:SS". Имя пользователя берется из присланного запроса.


Требования к платформе реализации, технологиям и инструментам:
 
1) Язык программирования – Java
 
2) Приложение должно обрабатывать исключения, которые могут возникнуть в его работе.
 
3) Приложение должно быть реализовано на Spring Framework, с использованием IoC.

4) Большим плюсом будет реализации не просто консольного приоложения, а Web-сервиса (для клиентской части). Интерфейс можно реализовать простой HTML-страницей с формой. В таком случае рекомендуется использовать Spring Boot Web. 

5) Для сборки и управления зависимостями использовать один из инстурментов -  Maven или Gradle. Все зависимости проекта описать в соответсвующих конфигурационный файлах (у Maven и Gradle свои форматы).

6) Завершенный проект обоих компонентов, необходимо разместить в системе контроля версий (на ваше усмотрение, в одном или в разных репозитория). Рекомендуется GitHub.
 

Требования к коду:
 
1) Исходный код должен содержать комментарии для классов и ключевых методов классов, объясняющие цели, задачи и нюансы реализации класса/метода.
 
3) Наименование переменных, классов и методов, должно следовать стандартам, рекомендуемым Java Code Convention. 
 

Дополнительно:

Реализовать сохранение принятых сервером сообщений в БД. Обязательно сохранять имя-фамилию клиента, сообщение, дату принятия сообщения сервером.
Для текущей задачи можно взять H2. Вся структура таблиц должна создаваться при старте сервера и быть описана в отдельном SQL файле.
 
