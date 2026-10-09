import { beforeEach, describe, expect, it } from 'vitest';
import { createPinia, setActivePinia } from 'pinia';
import { useCoursesStore } from './courses';

describe('useCoursesStore', () => {
  beforeEach(() => {
    setActivePinia(createPinia());
  });

  it('starts with all courses and no filter', () => {
    const store = useCoursesStore();
    expect(store.filteredCourses).toHaveLength(store.courses.length);
  });

  it('filters courses by category', () => {
    const store = useCoursesStore();
    store.setCategory('前端开发');

    expect(store.filteredCourses.length).toBeGreaterThan(0);
    expect(store.filteredCourses.every((course) => course.category === '前端开发')).toBe(true);
  });

  it('filters by keyword across title, description and tags', () => {
    const store = useCoursesStore();
    store.setKeyword('TypeScript');

    expect(store.filteredCourses.length).toBeGreaterThan(0);
    expect(
      store.filteredCourses.every((course) =>
        [course.title, course.description, ...course.tags]
          .join(' ')
          .toLowerCase()
          .includes('typescript'),
      ),
    ).toBe(true);
  });

  it('returns no courses when nothing matches', () => {
    const store = useCoursesStore();
    store.setKeyword('不存在的关键词');
    expect(store.filteredCourses).toHaveLength(0);
  });
});
