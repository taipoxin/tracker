
/*
use database work
 */

/*
key
work_date
iterations
time
*/

CREATE TABLE IF NOT EXISTS work_days(
	id INT NOT NULL AUTO_INCREMENT,
	work_date DATE NOT NULL,
	iterations TINYINT NOT NULL,
	work_time TEXT NOT NULL,
	PRIMARY KEY(id)
);



/*
key
ddate
ttime
*/
CREATE TABLE IF NOT EXISTS work_iters(
	id INT NOT NULL AUTO_INCREMENT,
	ddate DATE NOT NULL,
	ttime TIME NOT NULL,
	PRIMARY KEY(id)
);



DELIMITER $$





DROP PROCEDURE IF EXISTS `tiranid`.`create_indexes` $$
CREATE PROCEDURE `tiranid`.`create_indexes`(Given VARCHAR(20))
	BEGIN

		DECLARE IndexIsThere INTEGER;

		SELECT COUNT(1) INTO IndexIsThere FROM information_schema.statistics
		WHERE TABLE_SCHEMA = DATABASE()
					AND TABLE_NAME = 'work_days'
					AND INDEX_NAME = 'work_date_iterations';
		IF IndexIsThere = 0 THEN
			/*
      составной индекс по дате и итерациям
       */
			CREATE INDEX  work_date_iterations  ON work_days(work_date, iterations);

		END IF;

		SELECT COUNT(1) INTO IndexIsThere FROM information_schema.statistics
		WHERE TABLE_SCHEMA = DATABASE()
					AND TABLE_NAME = 'work_iters'
					AND INDEX_NAME = 'ddate';
		IF IndexIsThere = 0 THEN
			/*
      индекс по дате
       */
			CREATE INDEX ddate ON work_iters(ddate);

		END IF;
	END $$
DELIMITER ;


call create_indexes('');

