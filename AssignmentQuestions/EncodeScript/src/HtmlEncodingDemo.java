import org.apache.commons.lang.StringEscapeUtils;

public class HtmlEncodingDemo {
	
	public static void main(String args[]){
		
		String inputScript = "<script>alert('Test')</script>";
		String encodedScript = StringEscapeUtils.escapeHtml(inputScript);
		System.out.println("Input Script : "+inputScript);
		System.out.println("Encoded Script : "+encodedScript);
	}

}
