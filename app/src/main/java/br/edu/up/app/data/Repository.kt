package br.edu.up.app.data

class Repository {

    companion object {
        fun produtos(): MutableList<Produto> {
            val lista = mutableListOf(
                Produto(
                    1,
                    "Acompanhamentos",
                    "Manteiga, nata, mel, requeijão salgado, queijo branco.",
                    27.56,
                    160,
                    "cafe1.jpg",
                    1
                ),
                Produto(
                    2,
                    "Bruschetta de salmão e abacate",
                    "Pão preto, salmão defumado, queijo Philadelphia, abacate, tomate, ovos.",
                    52.49,
                    180,
                    "cafe2.jpg",
                    1
                ),
                Produto(
                    3,
                    "Croque Madame",
                    "Pão torrado, salame de vitela, ovos, manteiga, queijo, rúcula, cenoura, pepino, rabanete.",
                    35.1,
                    125,
                    "cafe3.jpg",
                    1
                ),
                Produto(
                    4,
                    "Panquecas de queijo",
                    "Folhada, recheio de queijo, rúcula, cenoura, pepino, rabanete.",
                    32.34,
                    110,
                    "cafe4.jpg",
                    1
                ),
                Produto(
                    5,
                    "Sanduíche de queijo",
                    "Pão torrado, queijo cheddar, queijo gouda, manteiga, rúcula, cenoura, pepino, rabanete.",
                    22.34,
                    110,
                    "cafe5.jpg",
                    1
                ),
                Produto(
                    6,
                    "Sanduíche de torrada escura",
                    "Pão escuro, presunto, ovos, queijo gouda, rúcula, cenoura, pepino, rabanete.",
                    28.14,
                    170,
                    "cafe6.jpg",
                    1
                ),
                Produto(
                    7,
                    "Omelete misto",
                    "Salada de ovos, filé de frango, queijo gouda, rúcula e tomate.",
                    25.1,
                    170,
                    "cafe7.jpg",
                    1
                ),
                Produto(
                    8,
                    "Prato de queijo",
                    "Queijo de leite de ovelha, queijo motal, requeijão, queijo branco.",
                    20.3,
                    170,
                    "aperitivo1.jpg",
                    2
                ),
                Produto(
                    9,
                    "Frios",
                    "Linguicinha, rolinho de frango, basturma de vitela.",
                    25.82,
                    120,
                    "aperitivo2.jpg",
                    2
                ),
                Produto(
                    10,
                    "Berinjelas ao estilo oriental",
                    "Berinjelas, nozes, curry, creme de leite, alho.",
                    19.44,
                    145,
                    "aperitivo3.jpg",
                    2
                ),
                Produto(
                    11,
                    "Lanche especial de berinjelas",
                    "Berinjela marinada, molho especial, verduras.",
                    21.9,
                    120,
                    "aperitivo4.jpg",
                    2
                ),
                Produto(
                    12,
                    "Tomates marinados em vinagre",
                    "Tomate, vinagre de uva, salsa, sementes de abóbora, azeite, alho.",
                    12.62,
                    120,
                    "aperitivo5.jpg",
                    2
                ),
                Produto(
                    13,
                    "Petisco de batata",
                    "Batata, queijo branco, queijo motal, tomate seco, queijo gouda, azeite, alho.",
                    17.84,
                    120,
                    "aperitivo6.jpg",
                    2
                ),
                Produto(
                    14,
                    "Salada de berinjela",
                    "Berinjela, tomate, pimentão, pimentão, óleo de milho, alho, verduras frescas.",
                    23.5,
                    120,
                    "salada1.jpg",
                    3
                ),
                Produto(
                    15,
                    "Salada Russa",
                    "Carne, batata, cenoura, ovos, pepino fresco, pepino em conserva, maionese, ervilha.",
                    25.1,
                    120,
                    "salada2.jpg",
                    3
                ),
                Produto(
                    16,
                    "Salada crocante de berinjela",
                    "Berinjelas, tomates, molho de ostra, sementes de gergelim branco.",
                    27.56,
                    130,
                    "salada3.jpg",
                    3
                ),
                Produto(
                    17,
                    "Sopa de frango com arroz",
                    "Frango, arroz redondo, cebola, cenoura, ameixa cereja, cúrcuma.",
                    27.56,
                    130,
                    "sopa1.jpg",
                    4
                ),
                Produto(
                    18,
                    "Sopa de macarrão com almôndegas",
                    "Macarrão caseiro, vitela, caldo de carne, cebola, cenoura, açafrão, feijão mungo.",
                    26.69,
                    180,
                    "sopa2.jpg",
                    4
                ),
                Produto(
                    19,
                    "Sopa de cebola",
                    "Cebola, farinha de trigo, batata, ovos, coentro, manteiga.",
                    23.5,
                    150,
                    "sopa3.jpg",
                    4
                ),
                Produto(
                    20,
                    "Filé mignon com batata",
                    "Filé mignon, manteiga, pimenta do reino, tomate, batata.",
                    57.29,
                    220,
                    "carne1.jpg",
                    5
                ),
                Produto(
                    21,
                    "Dolma do Azerbaijão",
                    "Vitela, borrego, beringela, tomate, pimentão.",
                    51.49,
                    230,
                    "carne2.jpg",
                    5
                ),
                Produto(
                    22,
                    "Fritas com Carne",
                    "Massa, vitela, rabo gordo, verduras frescas.",
                    39.89,
                    170,
                    "carne3.jpg",
                    5
                ),
                Produto(
                    23,
                    "Vitela com cogumelos em molho picante",
                    "Vitela, cogumelos, manteiga, molho de pimenta doce, cebola, coentro.",
                    35.69,
                    180,
                    "carne4.jpg",
                    5
                ),
                Produto(
                    24,
                    "Tabaka de frango",
                    "Frango para duas pessoas",
                    28.29,
                    150,
                    "frango1.jpg",
                    6
                ),
                Produto(
                    25,
                    "Filé de frango com batata",
                    "Filé de frango, batata, tomate",
                    22.49,
                    140,
                    "frango2.jpg",
                    6
                ),
                Produto(
                    26,
                    "Frango árabe",
                    "Frango, cebola, tomate, pimentão, berinjela, batata.",
                    27.29,
                    230,
                    "frango3.jpg",
                    6
                ),
                Produto(
                    27,
                    "Frutas da estação",
                    "Maçã, pêssego, morango, melão e uvas.",
                    15.1,
                    250,
                    "sobremesa1.jpg",
                    7
                ),
                Produto(
                    28,
                    "Geléia",
                    "Geléia de amoras, morango e pêssego.",
                    21.33,
                    150,
                    "sobremesa2.jpg",
                    7
                ),
                Produto(
                    29,
                    "Variedade de frutas secas e nozes",
                    "Castanhas, damasco, uvas secas e nozes",
                    19.3,
                    150,
                    "sobremesa3.jpg",
                    7
                ),
                Produto(
                    30,
                    "Sorvete",
                    "Sorvete de morango.",
                    14.09,
                    150,
                    "sobremesa4.jpg",
                    7
                ),
                Produto(
                    31,
                    "Vinho tinto",
                    "Vinho tinto seco, francês.",
                    47.89,
                    250,
                    "bebida1.jpg",
                    8
                ),
                Produto(
                    32,
                    "Cerveja Pilsen",
                    "Caneco de cerveja Pilsen de 500ml.",
                    11.9,
                    170,
                    "bebida2.jpg",
                    8
                ),
                Produto(
                    33,
                    "Xícara de chá",
                    "Xícara de chá de ervas egípcias.",
                    5.34,
                    150,
                    "bebida3.jpg",
                    8
                ),
                Produto(
                    34,
                    "Capuccino",
                    "Xícara pequena de café.",
                    8.3,
                    150,
                    "bebida4.jpg",
                    8
                ),
                Produto(
                    35,
                    "Coquetel de maracujá",
                    "Coquetel de vodka com maracujá.",
                    16.99,
                    150,
                    "bebida5.jpg",
                    8
                )
            )
            return lista
        }
    }
}