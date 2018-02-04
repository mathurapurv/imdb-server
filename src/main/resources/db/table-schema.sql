CREATE TABLE movie_details(
    movie_id INT NOT NULL AUTO_INCREMENT,
    movie_title VARCHAR(100) NOT NULL,    
    release_date DATE,
    PRIMARY KEY ( movie_id )
    );
	
	
CREATE TABLE reviews(
	review_id INT NOT NULL AUTO_INCREMENT,
    movie_id INT ,
    comments VARCHAR(100) NOT NULL,  
	rating DECIMAL(5,2) default 0,    
    PRIMARY KEY ( review_id )
    );	
	

CREATE TABLE shows (
	show_id INT NOT NULL AUTO_INCREMENT,
	movie_id INT ,
	cinema VARCHAR(255) NOT NULL,
	timing DATETIME,
	class VARCHAR(32)  ,
	PRIMARY KEY (show_id)
);

	
	
CREATE  TABLE users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));	
  
 CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id));