-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 01-Dez-2022 às 20:34
-- Versão do servidor: 10.4.25-MariaDB
-- versão do PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `cartaoassur`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `assur`
--

CREATE TABLE `assur` (
  `idcartao` int(11) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `cpf` int(11) DEFAULT NULL,
  `valorrecarga` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `assur`
--

INSERT INTO `assur` (`idcartao`, `nome`, `cpf`, `valorrecarga`) VALUES
(1, 'e', 5, 7),
(2, 'pedro', 900, 34),
(3, 'r', 6, 9),
(4, 'coco', 9000000, 100),
(5, 'w', 2, 2),
(6, 'pedro', 6180, 20),
(7, 'asd', 999999999, 3),
(8, 'as', 0, 3),
(9, 'epdro', 9090090, 21),
(10, 'epdr', 255, 12);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `assur`
--
ALTER TABLE `assur`
  ADD PRIMARY KEY (`idcartao`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `assur`
--
ALTER TABLE `assur`
  MODIFY `idcartao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
