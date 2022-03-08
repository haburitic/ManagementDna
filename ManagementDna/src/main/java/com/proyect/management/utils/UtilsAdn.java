package com.proyect.management.utils;

import java.util.List;

/**
 * class util.
 * @author HABUR
 *
 */
public class UtilsAdn {

	/**
	 * @param list
	 * @return char[][] Crea una matriz con los datos ingresados
	 */
	public static char[][] createMatrix(List<String> list) {
		// crea una matriz n * n
		char[][] matrix = new char[list.size()][list.size()];

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				matrix[i][j] = list.get(i).charAt(j);
			}

		}

		return matrix;
	}


}
