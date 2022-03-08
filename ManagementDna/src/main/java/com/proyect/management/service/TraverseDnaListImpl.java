package com.proyect.management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.proyect.management.dto.PosicionElementDTO;
import com.proyect.management.dto.ProcessInfoDTO;
import com.proyect.management.dto.RequestDTO;
import com.proyect.management.interfaces.ITraverseDnaList;
import com.proyect.management.utils.UtilsAdn;

/**
 * Traverse Dna List.
 * @author HABUR
 *
 */
@Service
public class TraverseDnaListImpl implements ITraverseDnaList {

	@Override
	public ProcessInfoDTO dnaList(RequestDTO dna) {
		char[][] responseList = UtilsAdn.createMatrix(dna.getAdnList());
		return isMutant(responseList);
	}

	/**
	 * validate isMutant.
	 * @param matrix array.
	 * @return boolean ProcessInfoDTO que el ADN corresponda a un mutante
	 */

	public static ProcessInfoDTO isMutant(final char[][] matrix) {
		char caracter = 0;
		int count = 0;

		char[][] mutanteLis = new char[matrix.length][matrix.length];
		ProcessInfoDTO processInfoDTO = new ProcessInfoDTO();
		processInfoDTO.setMutanteList(mutanteLis);

		for (int i = 0; i < matrix.length; i++) {
			List<PosicionElementDTO> val = new ArrayList<>();

			recursivoDiagonal(matrix, i, 0, processInfoDTO, caracter, count, 0, 1, val);
			recursivoDiagonal(matrix, 0, i, processInfoDTO, caracter, count, 1, 0, val);

			recursivoDiagonal(matrix, i, matrix.length - 1, processInfoDTO, caracter, count, 1, -1, val);
			recursivoDiagonal(matrix, 0, matrix.length - 2 - i, processInfoDTO, caracter, count, 1, -1, val);
			recursivoDiagonal(matrix, i, 0, processInfoDTO, caracter, count, 1, 1, val);
			recursivoDiagonal(matrix, 0, 1 + i, processInfoDTO, caracter, count, 1, 1, val);

		}
		return processInfoDTO;
	}

	/**
	 * recursivo Diagonal.
	 * @param matrix
	 * @param fila
	 * @param columna
	 * @param processInfoDTO
	 * @param caracter
	 * @param count
	 * @param ingrementoFila
	 * @param ingrementoColumna
	 * @param val
	 */
	public static void recursivoDiagonal(final char[][] matrix, final int fila, final int columna,
			final ProcessInfoDTO processInfoDTO, char caracter, int count, final int ingrementoFila,
			final int ingrementoColumna, final List<PosicionElementDTO> val) {

		if (fila > matrix.length - 1 ||columna > matrix.length - 1 || columna < 0) {
			return;
		}

		char caracterTmp = matrix[fila][columna];
		if (caracter == 0) {
			caracter = matrix[fila][columna];
			val.add(new PosicionElementDTO(fila, columna));
			count++;
		} else if (caracter == caracterTmp) {
			val.add(new PosicionElementDTO(fila, columna));
			count++;

			if (count == 4) {
				createRegistroMutanteDiagonal(processInfoDTO, matrix, val);
				return;
			}
		} else {
			count = 0;
			val.clear();

		}

		recursivoDiagonal(matrix, fila + ingrementoFila, columna + ingrementoColumna, processInfoDTO, caracter, count,
				ingrementoFila, ingrementoColumna, val);

	}

	/**
	 * create register and save inmemory.
	 * @param processInfoDTO
	 * @param matrix
	 * @param val
	 */
	private static void createRegistroMutanteDiagonal(final ProcessInfoDTO processInfoDTO, final char[][] matrix,
			final List<PosicionElementDTO> val) {
		for (PosicionElementDTO posicionElemento : val) {

			if (!Character.isLetter(
					processInfoDTO.getMutanteList()[posicionElemento.getFila()][posicionElemento.getColumna()])) {
				processInfoDTO.getMutanteList()[posicionElemento.getFila()][posicionElemento
						.getColumna()] = matrix[posicionElemento.getFila()][posicionElemento.getColumna()];

			}
		}
		processInfoDTO.incrementMutant();
	}

}
