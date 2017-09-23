package io.github.wulkanowy.api;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import io.github.wulkanowy.api.attendance.AttendanceStatistics;
import io.github.wulkanowy.api.attendance.AttendanceTable;
import io.github.wulkanowy.api.grades.GradesList;
import io.github.wulkanowy.api.grades.SubjectsList;
import io.github.wulkanowy.api.login.NotLoggedInErrorException;
import io.github.wulkanowy.api.notes.AchievementsList;
import io.github.wulkanowy.api.notes.NotesList;
import io.github.wulkanowy.api.school.SchoolInfo;
import io.github.wulkanowy.api.school.TeachersInfo;
import io.github.wulkanowy.api.timetable.Timetable;
import io.github.wulkanowy.api.user.BasicInformation;
import io.github.wulkanowy.api.user.FamilyInformation;

public class VulcanTest extends Vulcan {

    private Vulcan vulcan;

    @Before
    public void setUp() throws Exception {
        StudentAndParent snp = Mockito.mock(StudentAndParent.class);
        vulcan = Mockito.mock(Vulcan.class);
        Mockito.when(vulcan.getStudentAndParent())
                .thenReturn(snp);
    }

    @Test(expected = NotLoggedInErrorException.class)
    public void getStudentAndParentTest() throws Exception {
        Mockito.when(vulcan.getStudentAndParent()).thenCallRealMethod();
        vulcan.getStudentAndParent();
    }

    @Test(expected = NotLoggedInErrorException.class)
    public void getAttendanceExceptionText() throws Exception {
        Mockito.when(vulcan.getAttendanceTable()).thenCallRealMethod();
        Mockito.when(vulcan.getStudentAndParent()).thenThrow(NotLoggedInErrorException.class);

        vulcan.getAttendanceTable();
    }

    @Test
    public void getAttendanceTest() throws Exception {
        Mockito.when(vulcan.getAttendanceTable()).thenCallRealMethod();
        Assert.assertThat(vulcan.getAttendanceTable(),
                CoreMatchers.instanceOf(AttendanceTable.class));
    }

    @Test
    public void getAttendanceStatisticTest() throws Exception {
        Mockito.when(vulcan.getAttendanceStatistics()).thenCallRealMethod();
        Assert.assertThat(vulcan.getAttendanceStatistics(),
                CoreMatchers.instanceOf(AttendanceStatistics.class));
    }

    @Test
    public void getGradesListTest() throws Exception {
        Mockito.when(vulcan.getGradesList()).thenCallRealMethod();
        Assert.assertThat(vulcan.getGradesList(),
                CoreMatchers.instanceOf(GradesList.class));
    }

    @Test
    public void getSubjectListTest() throws Exception {
        Mockito.when(vulcan.getSubjectsList()).thenCallRealMethod();
        Assert.assertThat(vulcan.getSubjectsList(),
                CoreMatchers.instanceOf(SubjectsList.class));
    }

    @Test
    public void getAchievementsListTest() throws Exception {
        Mockito.when(vulcan.getAchievementsList()).thenCallRealMethod();
        Assert.assertThat(vulcan.getAchievementsList(),
                CoreMatchers.instanceOf(AchievementsList.class));
    }

    @Test
    public void getNotesListTest() throws Exception {
        Mockito.when(vulcan.getNotesList()).thenCallRealMethod();
        Assert.assertThat(vulcan.getNotesList(),
                CoreMatchers.instanceOf(NotesList.class));
    }

    @Test
    public void getSchoolInfoTest() throws Exception {
        Mockito.when(vulcan.getSchoolInfo()).thenCallRealMethod();
        Assert.assertThat(vulcan.getSchoolInfo(),
                CoreMatchers.instanceOf(SchoolInfo.class));
    }

    @Test
    public void getTeachersInfoTest() throws Exception {
        Mockito.when(vulcan.getTeachersInfo()).thenCallRealMethod();
        Assert.assertThat(vulcan.getTeachersInfo(),
                CoreMatchers.instanceOf(TeachersInfo.class));
    }

    @Test
    public void getTimetableTest() throws Exception {
        Mockito.when(vulcan.getTimetable()).thenCallRealMethod();
        Assert.assertThat(vulcan.getTimetable(),
                CoreMatchers.instanceOf(Timetable.class));
    }

    @Test
    public void getBasicInformationTest() throws Exception {
        Mockito.when(vulcan.getBasicInformation()).thenCallRealMethod();
        Assert.assertThat(vulcan.getBasicInformation(),
                CoreMatchers.instanceOf(BasicInformation.class));
    }

    @Test
    public void getFamilyInformationTest() throws Exception {
        Mockito.when(vulcan.getFamilyInformation()).thenCallRealMethod();
        Assert.assertThat(vulcan.getFamilyInformation(),
                CoreMatchers.instanceOf(FamilyInformation.class));
    }
}
