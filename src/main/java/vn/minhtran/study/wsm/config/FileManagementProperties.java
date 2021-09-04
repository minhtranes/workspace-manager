package vn.minhtran.study.wsm.config;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.unit.DataSize;

public class FileManagementProperties {
	private Reporter reporter;
	private Map<String, Action> actions = new HashMap<>();

	public Reporter getReporter() {
		return reporter;
	}

	public void setReporter(Reporter reporter) {
		this.reporter = reporter;
	}

	public Map<String, Action> getActions() {
		return actions;
	}

	public void setActions(Map<String, Action> actions) {
		this.actions = actions;
	}

	public static class Action {

		private String action;

		public void setAction(String action) {
			this.action = action;
		}

		public String getAction() {
			return action;
		}

	}

	private static class Reporter {
		private boolean enabled;
		private String schedule;
		private Map<String, Rule> rules = new HashMap<>();

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}

		public String getSchedule() {
			return schedule;
		}

		public void setSchedule(String schedule) {
			this.schedule = schedule;
		}

		public Map<String, Rule> getRules() {
			return rules;
		}

		public void setRules(Map<String, Rule> rules) {
			this.rules = rules;
		}

	}

	public interface Rule {

	}

	public static class SizeRule implements Rule {
		private DataSize largerThan;

		public DataSize getLargerThan() {
			return largerThan;
		}

		public void setLargerThan(DataSize largerThan) {
			this.largerThan = largerThan;
		}
	}

	public static class ObsoletedRule implements Rule {
		private Duration olderThan;

		public Duration getOlderThan() {
			return olderThan;
		}

		public void setOlderThan(Duration olderThan) {
			this.olderThan = olderThan;
		}
	}
}
