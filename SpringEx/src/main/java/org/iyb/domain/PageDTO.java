package org.iyb.domain;

public class PageDTO {
	private int startPage;//���� ������ ��ȣ
	private int endPage;//�� ������ ��ȣ
	private boolean prev;//���� ������ ����
	private boolean next;//���� ������ ����
	private int total;//board���̺��� �� ������ �� ��
	private Criteria cri;//endPage�� ����ϱ� ���� pageNum�� �ʿ��ϹǷ� CriteriaŬ������ ����
	
	public PageDTO(Criteria cri, int total){
		this.cri=cri;
		this.total=total;
		//(int)(Math.ceil(������������ȣ/10.0))*10 ���� ����� endPage�� ����(��ü�Ǽ��� ������� ����)
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
		this.startPage = endPage-9;//10-9=1, 20-9=11..... endPage�� ������ ���� ������ �Ǳ� ������ this�� �� �ҿ��� �ȴ�.
		//��ü�Ǽ��� ����� endPage->realEnd
		//(int)(Math.ceil(��ü�Ǽ�*1.0))/10; 1.0 : �Ҽ������� ���Ǳ� ���Ͽ�
		int realEnd=(int)(Math.ceil((total*10)/cri.getAmount()));
		//realEnd < endPage => realEnd���� endPage�� ����
		if(realEnd<endPage) {
			this.endPage=realEnd;
		}
		this.prev=this.startPage>1;
		this.next=this.endPage<realEnd;
	}
	
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	@Override
	public String toString() {
		return "PageDTO [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", total=" + total + ", cri=" + cri + "]";
	}
	
}
