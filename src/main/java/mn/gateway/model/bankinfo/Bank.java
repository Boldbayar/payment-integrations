package mn.gateway.model.bankinfo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bank implements Serializable {

	private static final long serialVersionUID = -2706468142375000870L;


	private Integer id;

	private String name;
	private String nameEn;
	private String code;

}
