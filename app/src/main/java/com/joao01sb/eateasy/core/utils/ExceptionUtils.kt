package com.joao01sb.eateasy.core.utils

import com.google.gson.JsonSyntaxException
import java.io.IOException

fun mapExceptionToErrorMessage(e: Throwable): String {
    return when (e) {
        is IOException -> "Erro de conexão. Verifique sua internet."
        is NoSuchElementException -> "Nenhum resultado encontrado para o termo informado."
        is IllegalArgumentException -> "O termo de busca não pode ser vazio."
        is JsonSyntaxException -> "Erro ao processar os dados recebidos."
        else -> "Erro inesperado. Tente novamente."
    }
}