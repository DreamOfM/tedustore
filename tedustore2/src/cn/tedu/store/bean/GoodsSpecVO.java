package cn.tedu.store.bean;

public class GoodsSpecVO {

	private Integer id;
	private String spec;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	 public GoodsSpecVO() {
		
	}
	@Override
	public String toString() {
		return "GoodsSpecVO [id=" + id + ", spec=" + spec + "]";
	}
	

}
