package domain.model;


import java.util.Objects;


public class Project {
    private int projectid;
    private String name;
    private Team team;
    private String start;
    private String end;

    public Project(int projectID, String name, String team, String start, String end) {
        this(name, team, start, end);
        setProjectid(projectID);
    }

    public Project() {
    }

    public Project(String name, String team, String start, String end) {
        setEnd(end);
        setStart(start);
        setName(name);
        setTeam(team);

    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(String team) {
        try {
            this.team = Team.valueOf(team.toLowerCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("There is no team with value " + team);
        }
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getProjectid() {
        return projectid;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        String t = this.team.getStringValue();
        return t.substring(0,1).toUpperCase() + t.substring(1).toLowerCase();
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;
        Project project = (Project) o;
        return Objects.equals(name, project.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectID=" + projectid +
                ", name='" + name + '\'' +
                ", team=" + team +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public void updateProject(Project p){
        setName(p.getName());
        setStart(p.getStart());
        setEnd(p.getEnd());
        setTeam(p.getTeam());
    }
}
