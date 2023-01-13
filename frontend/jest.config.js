module.exports = {
    collectCoverage: true,
    collectCoverageFrom: ['src/**/*.{js,jsx}'],
    coverageDirectory: 'coverage',
    testEnvironment: 'jsdom',
    setupFilesAfterEnv: ['./jest.setup.js'],
    moduleNameMapper: {
        "^.+\\.(css|less|scss)$": "identity-obj-proxy",
        "^.+\\.svg$": "jest-svg-transformer"
      },
}

