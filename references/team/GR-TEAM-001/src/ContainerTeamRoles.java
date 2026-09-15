package com.company.windchill.reference.team;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import wt.inf.container.WTContainer;
import wt.inf.team.ContainerTeam;
import wt.inf.team.ContainerTeamHelper;
import wt.inf.team.ContainerTeamManaged;
import wt.org.OrganizationServicesHelper;
import wt.org.WTGroup;
import wt.org.WTPrincipal;
import wt.org.WTUser;
import wt.project.Role;
import wt.util.WTException;

public final class ContainerTeamRoles {

    public static List<Role> rolesOf(WTContainer container, WTUser user) throws WTException {
        List<Role> roles = new ArrayList<>();

        ContainerTeam team = ContainerTeamHelper.service.getContainerTeam(
                (ContainerTeamManaged) container);

        Enumeration<?> groups = ContainerTeamHelper.service.findContainerTeamGroups(
                team,
                ContainerTeamHelper.ROLE_GROUPS);

        while (groups.hasMoreElements()) {
            WTGroup group = (WTGroup) groups.nextElement();

            if (OrganizationServicesHelper.manager.isMember(group, user)) {
                roles.add(Role.toRole(group.getName()));
            }
        }

        return roles;
    }

    public static void addMembers(
            ContainerTeam team,
            Role role,
            List<WTPrincipal> principals) throws WTException {

        ContainerTeamHelper.service.addMembers(team, role, principals);
    }

    private ContainerTeamRoles() {
    }
}
