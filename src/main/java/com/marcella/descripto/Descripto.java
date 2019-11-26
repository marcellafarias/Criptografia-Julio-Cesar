package com.marcella.descripto;

public final class Descripto {

	private static final int A = 'a';
	private static final int Z = 'z';
	private static final char alfabeto[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	private Descripto() {
		super();
	}

	public static String descriptografar(final String mensagem, final int casas) {
		final StringBuilder builder = new StringBuilder();
		if (mensagem != null) {
			final char caracteres[] = mensagem.trim().toLowerCase().toCharArray();
			for (char caractere : caracteres) {
				if ((caractere < A) || (caractere > Z)) {
					builder.append(caractere);
					continue;
				}
				int index = (caractere - A) - casas;
				if (index < 0) {
					index = alfabeto.length + index;
				}
				builder.append(alfabeto[index]);
			}
		}
		return builder.toString();
	}

}
