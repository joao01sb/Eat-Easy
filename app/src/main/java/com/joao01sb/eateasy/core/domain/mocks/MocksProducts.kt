package com.joao01sb.eateasy.core.domain.mocks

import com.joao01sb.eateasy.core.domain.model.ShoppingCartProduct
import com.joao01sb.eateasy.core.domain.model.Product

object MocksProducts {

    val productsSale = listOf(
        Product(
            message = "Deliciosa e saudável!",
            name = "Salada Franga 1",
            price = "12.00",
            imageUrl = "https://www.designi.com.br/images/preview/11110295.jpg"
        ),
        Product(
            message = "Refrescante e nutritiva!",
            name = "Salada Franga 2",
            price = "15.00",
            imageUrl = "https://www.designi.com.br/images/preview/11110296.jpg"
        ),
        Product(
            message = "Ideal para um almoço leve.",
            name = "Salada Franga 3",
            price = "13.50",
            imageUrl = "https://www.designi.com.br/images/preview/11110297.jpg"
        ),
        Product(
            message = "A combinação perfeita de sabores.",
            name = "Salada Franga 4",
            price = "18.00",
            imageUrl = "https://www.designi.com.br/images/preview/11110298.jpg"
        ),
        Product(
            message = "Saudável e deliciosa!",
            name = "Salada Franga 5",
            price = "16.00",
            imageUrl = "https://www.designi.com.br/images/preview/11110299.jpg"
        ),
        Product(
            message = "Uma explosão de frescor!",
            name = "Salada Franga 6",
            price = "14.00",
            imageUrl = "https://www.designi.com.br/images/preview/11110300.jpg"
        ),
        Product(
            message = "Sabor único, textura crocante.",
            name = "Salada Franga 7",
            price = "11.00",
            imageUrl = "https://www.designi.com.br/images/preview/11110301.jpg"
        ),
        Product(
            message = "Leve e perfeita para qualquer refeição.",
            name = "Salada Franga 8",
            price = "19.00",
            imageUrl = "https://www.designi.com.br/images/preview/11110302.jpg"
        ),
        Product(
            message = "Nutritiva e saborosa.",
            name = "Salada Franga 9",
            price = "12.50",
            imageUrl = "https://www.designi.com.br/images/preview/11110303.jpg"
        ),
        Product(
            message = "Feita com ingredientes frescos.",
            name = "Salada Franga 10",
            price = "10.00",
            imageUrl = "https://www.designi.com.br/images/preview/11110304.jpg"
        )
    )

    val productsCart  = listOf(
        "Food" to ShoppingCartProduct(
            name = "Pizza de Calabresa",
            price = "R$ 39,90",
            imageUrl = "https://www.designi.com.br/produto-imagem/pizza-de-calabresa.jpg",
            quantity = 1,
            categoty = "Food",
            especification = "Massa tradicional, queijo muçarela, calabresa fatiada e orégano"
        ),
        "Food" to ShoppingCartProduct(
            name = "Hambúrguer Artesanal",
            price = "R$ 24,90",
            imageUrl = "https://www.designi.com.br/produto-imagem/hamburguer-artesanal.jpg",
            quantity = 1,
            categoty = "Food",
            especification = "Pão brioche, carne bovina de 180g, queijo cheddar e bacon"
        ),
        "Food" to ShoppingCartProduct(
            name = "Sushi Combo 16 Peças",
            price = "R$ 49,90",
            imageUrl = "https://www.designi.com.br/produto-imagem/sushi-combo.jpg",
            quantity = 1,
            categoty = "Food",
            especification = "8 nigiris, 4 hots, 4 sashimis com molho shoyu incluso"
        ),
        "Food" to ShoppingCartProduct(
            name = "Torta de Chocolate",
            price = "R$ 19,90",
            imageUrl = "https://www.designi.com.br/produto-imagem/torta-de-chocolate.jpg",
            quantity = 1,
            categoty = "Food",
            especification = "Base crocante com recheio cremoso de chocolate belga"
        ),
        "Bebidas" to ShoppingCartProduct(
            name = "Suco de Laranja Natural",
            price = "R$ 8,90",
            imageUrl = "https://www.designi.com.br/produto-imagem/suco-de-laranja.jpg",
            quantity = 1,
            categoty = "Bebidas",
            especification = "Suco 100% natural, sem açúcar, 300ml"
        )
    )



}