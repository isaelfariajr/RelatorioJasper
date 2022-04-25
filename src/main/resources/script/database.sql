-- Cria o schema
CREATE SCHEMA `arquivojm`;

-- Cria a tabela de cliente
CREATE  TABLE `arquivojm`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(45) NOT NULL ,
  `cnpj` VARCHAR(45) NULL ,
  `endereco` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) );

-- Cria a tabela de caixa
CREATE  TABLE `arquivojm`.`caixa` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `cliente` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_cliente` (`cliente` ASC) );

-- Cria a tabela de tipos de documento:
CREATE  TABLE `arquivojm`.`tipo_documento` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) );

-- Cria a tabela de documento:
CREATE  TABLE `arquivojm`.`documento` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `caixa` INT NOT NULL ,
  `tipo_documento` INT NOT NULL ,
  `cliente` INT NOT NULL ,
  `nome` VARCHAR(45) NOT NULL ,
  `dt_entrada` DATE NULL ,
  `observacao` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_caixa` (`caixa` ASC) ,
  INDEX `fk_tipo_documento` (`tipo_documento` ASC) ,
  INDEX `fk_cliente` (`cliente` ASC) );