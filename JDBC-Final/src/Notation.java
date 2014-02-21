
public class Notation {

	private float moycc;
	private float moytest;
	
	public float getMoycc() {
		return moycc;
	}
	public void setMoycc(float moycc) {
		this.moycc = moycc;
	}
	public float getMoytest() {
		return moytest;
	}
	public void setMoytest(float moytest) {
		this.moytest = moytest;
	}
	@Override
	public String toString() {
		return "Notation [moycc=" + moycc + ", moytest=" + moytest + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(moycc);
		result = prime * result + Float.floatToIntBits(moytest);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notation other = (Notation) obj;
		if (Float.floatToIntBits(moycc) != Float.floatToIntBits(other.moycc))
			return false;
		if (Float.floatToIntBits(moytest) != Float
				.floatToIntBits(other.moytest))
			return false;
		return true;
	}
	
}
