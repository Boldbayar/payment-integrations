package mn.gateway.payload.response.base;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagedResponse<T> {

  private List<T> content;
  private int page;
  private int size;
  private long totalElements;
  private int totalPages;
  private boolean last;

  public PagedResponse() {}

  public PagedResponse(
      final List<T> content,
      final int page,
      final int size,
      final long totalElements,
      final int totalPages,
      final boolean last) {
    this.content = content;
    this.page = page;
    this.size = size;
    this.totalElements = totalElements;
    this.totalPages = totalPages;
    this.last = last;
  }

  public List<T> getContent() {
    return content;
  }
}
