package pe.edu.utp.semana06recycleview.Providers

import pe.edu.utp.semana06recycleview.R
import pe.edu.utp.semana06recycleview.modelo.Platos

class PlatoProvider{
    companion object {
        val platosList = mutableListOf<Platos>(
            Platos("Plato 1", 12.99, 4.2f, "Delicioso plato de pasta con salsa de tomate y albóndigas.", R.drawable.platillo01),
            Platos("Plato 2", 15.49, 4.5f, "Hamburguesa con carne a la parrilla, lechuga, tomate y queso cheddar.", R.drawable.platillo02),
            Platos("Plato 3", 9.99, 3.8f, "Pizza de pepperoni con una base de masa crujiente y queso derretido.", R.drawable.platillo03),
            Platos("Plato 4", 21.99, 4.7f, "Salmón a la parrilla con espárragos y salsa de limón.", R.drawable.platillo04),
            Platos("Plato 5", 14.99, 4.1f, "Ensalada fresca con tomates, pepinos y aderezo de vinagreta.", R.drawable.platillo05),
            Platos("Plato 6", 18.99, 4.4f, "Sándwich de pollo a la parrilla con aguacate y mayonesa.", R.drawable.platillo06),
            Platos("Plato 7", 10.99, 3.5f, "Arroz frito con pollo, huevo, guisantes y zanahorias.", R.drawable.platillo07),
            Platos("Plato 8", 17.99, 4.6f, "Tacos de carne asada con cebolla, cilantro y salsa picante.", R.drawable.platillo08),
            Platos("Plato 9", 8.99, 3.2f, "Sopa de lentejas con verduras y un toque de comino.", R.drawable.platillo09),
            Platos("Plato 10", 12.99, 3.9f, "Pollo al curry con arroz y pan naan recién horneado.", R.drawable.platillo10),
            Platos("Plato 11", 14.99, 4.3f, "Tarta de queso con fresas frescas y crema batida.", R.drawable.platillo01),
            Platos("Plato 12", 13.49, 4.0f, "Sushi variado con nigiri, maki y sashimi.", R.drawable.platillo02),
            Platos("Plato 13", 11.99, 3.7f, "Tacos de pescado con repollo y salsa de chipotle.", R.drawable.platillo03),
            Platos("Plato 14", 20.99, 4.8f, "Filete a la parrilla con puré de papas y espárragos.", R.drawable.platillo04),
            Platos("Plato 15", 16.99, 4.4f, "Ensalada César con pollo a la parrilla y crutones.", R.drawable.platillo05),
            Platos("Plato 16", 22.99, 4.6f, "Ternera a la parrilla con champiñones y salsa de vino tinto.", R.drawable.platillo06),
            Platos("Plato 17", 10.99, 3.6f, "Ramen con huevo cocido y cebollas verdes.", R.drawable.platillo07),
            Platos("Plato 18", 15.99, 4.2f, "Huevos Benedictinos con jamón y salsa holandesa.", R.drawable.platillo08),
            Platos("Plato 19", 12.99, 3.9f, "Sopa de calabaza con canela y crema.", R.drawable.platillo09),
            Platos("Plato 20", 14.99, 4.3f, "Bistec con patatas fritas y ensalada mixta.", R.drawable.platillo01)

        )
        val platosListNodata = mutableListOf<Platos>(
            Platos("No existe el dato", 0.0, 0.0F, "No data", R.drawable.nodata),
        )
    }
}
