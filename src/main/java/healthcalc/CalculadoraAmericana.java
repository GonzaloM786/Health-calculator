package healthcalc;

public class CalculadoraAmericana extends BaseDecorator{
	
	// Altura en pies y peso en libras
	// 1 Kg = 2.20462 libras
	// 1 metro = 3.28084 pies 
	
		@Override
		public double bmr(char genero, int edad, float altura, int peso) throws Exception {
			float height = (float) (altura/3.28084);
			int weight = (int) Math.round(peso*1000/2.20462);
			
			double resultado = super.bmr(genero, edad, height, weight);
			System.out.println("La persona con altura "+height+" metros y "+ Math.round(weight/1000)+" Kg tiene un BMR de "+resultado);
			System.out.println("The person "+height+" meters tall and "+ Math.round(weight/1000)+" Kg has a BMR of "+resultado);
			return resultado;
		}
		
		@Override
		public int pesoIdeal(char genero, float altura) throws Exception {
			float height = (float) (altura/3.28084);
			return super.pesoIdeal(genero, height);
		}
		
		@Override
		public float alturaMedia() {
			return super.alturaMedia();
		}
		
		@Override
		public float pesoMedio() {
			return super.pesoMedio();
		}

		@Override
		public float edadMedia() {
			return super.edadMedia();
		}

		@Override
		public float bmrMedio() {
			return super.bmrMedio();
		}

		@Override
		public int numSexoH() {
			return super.numSexoH();
		}

		@Override
		public int numSexoM() {
			return super.numSexoM();
		}

		@Override
		public int numTotalPacientes() {
			return super.numTotalPacientes();
		}
}
