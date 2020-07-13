package com.tobrasil.apiAluno.handler;

import javax.annotation.Generated;

public class ResourceNotFoundDetails {
	private String title;
	private int status;
	private String detail;
	private Long timestamp;
	private String devMsg;

	@Generated("SparkTools")
	private ResourceNotFoundDetails(Builder builder) {
		this.title = builder.title;
		this.status = builder.status;
		this.detail = builder.detail;
		this.timestamp = builder.timestamp;
		this.devMsg = builder.devMsg;
	}
	
	private ResourceNotFoundDetails() {
	}

	public String getTitle() {
		return title;
	}

	public int getStatus() {
		return status;
	}

	public String getDetail() {
		return detail;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public String getDevMsg() {
		return devMsg;
	}

	/**
	 * Creates builder to build {@link ResourceNotFoundDetails}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link ResourceNotFoundDetails}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private String title;
		private int status;
		private String detail;
		private Long timestamp;
		private String devMsg;

		private Builder() {
		}

		public Builder withTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder withStatus(int status) {
			this.status = status;
			return this;
		}

		public Builder withDetail(String detail) {
			this.detail = detail;
			return this;
		}

		public Builder withTimestamp(Long timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public Builder withDevMsg(String devMsg) {
			this.devMsg = devMsg;
			return this;
		}

		public ResourceNotFoundDetails build() {
			return new ResourceNotFoundDetails(this);
		}
	}
	
	
	
	

}
