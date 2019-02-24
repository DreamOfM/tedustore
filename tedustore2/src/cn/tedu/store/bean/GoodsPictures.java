package cn.tedu.store.bean;

public class GoodsPictures {
	private Integer id;
	private Integer goods_id;
	private String url;

	private Integer turn;
	private String filename;
	private Integer size;
	private Integer width;
	private Integer height;
	private Integer summary;

	@Override
	public String toString() {
		return "GoodsPictures [id=" + id + ", goodsId=" + goods_id + ", url=" + url + ", turn=" + turn + ", filename="
				+ filename + ", size=" + size + ", width=" + width + ", height=" + height + ", summary=" + summary
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGoodsId() {
		return goods_id;
	}

	public void setGoodsId(Integer goodsId) {
		this.goods_id = goodsId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getTurn() {
		return turn;
	}

	public void setTurn(Integer turn) {
		this.turn = turn;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getSummary() {
		return summary;
	}

	public void setSummary(Integer summary) {
		this.summary = summary;
	}

	public GoodsPictures() {

	}

}
