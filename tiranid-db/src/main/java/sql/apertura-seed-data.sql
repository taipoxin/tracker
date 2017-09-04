
	
/*
добавление новой строки заявки
связи и индексы не делал
*/

INSERT INTO master_responses (login, req_number, message, date) 
	VALUES ('good_master', 127001, 'Сообщение о принятии запроса', '2007-09-03 04:20:00');


INSERT INTO clients_requests (login, req_number, message, date) 
	VALUES ('poor_user', 127001, 'Помогите, сломался комплюхтер', '2007-09-02 04:20:00');
	
