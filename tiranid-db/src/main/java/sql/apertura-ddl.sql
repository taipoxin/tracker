

/*
логин мастера
номер заявки (как у clients_requests)
сообщение
дата
*/

CREATE TABLE IF NOT EXISTS master_responses(
	id INT NOT NULL AUTO_INCREMENT,
	login VARCHAR(50) NOT NULL,
	req_number INT(15) NOT NULL,
	message TEXT NOT NULL,
	date DATETIME NOT NULL,
	PRIMARY KEY(id)
);

/*
логин клиента
номер заявки
сообщение
дата
*/

CREATE TABLE IF NOT EXISTS clients_requests(
	id INT NOT NULL AUTO_INCREMENT,
	login VARCHAR(50) NOT NULL,
	req_number INT(15) NOT NULL,
	message TEXT NOT NULL,
	date DATETIME NOT NULL,
	PRIMARY KEY(id)
);
