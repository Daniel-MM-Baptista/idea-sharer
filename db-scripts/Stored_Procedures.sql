DROP PROCEDURE IF EXISTS verifyAuth;
DELIMITER //
CREATE PROCEDURE verifyAuth (loginCredential VARCHAR(60), password VARCHAR(30))
BEGIN
    DECLARE hash VARCHAR(255);
    DECLARE salt BLOB;
    
    SELECT passwordHash, passwordSalt 
    INTO hash, salt 
    FROM user 
    WHERE email = email_to_check OR username = loginCredential;

    IF SHA2(CONCAT(password, salt), 256) != hash THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "incorrect_credentials";
	END IF;
END; //
DELIMITER ;

DROP PROCEDURE IF EXISTS registerUser;
DELIMITER //
CREATE PROCEDURE registerUser(name VARCHAR(40), newEmail VARCHAR(60), pass VARCHAR(255))
BEGIN
    DECLARE salt BLOB;
    SET salt = RANDOM_BYTES(16);

	IF (SELECT id FROM user WHERE email = newEmail OR username = name) IS NOT NULL THEN
		SIGNAL SQLSTATE '46000' SET MESSAGE_TEXT = "user_already_exists";
    END IF;
    
    INSERT INTO `User` (`id`, `username`, `email`, `passwordHash`, `passwordSalt`, `creationDate`)
    VALUES (UUID(), name, newEmail, SHA2(CONCAT(pass, salt), 256), salt, DATE(NOW()));
END //
DELIMITER ;